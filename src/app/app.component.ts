import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FilamentService } from './service/filament.service';
import { BehaviorSubject, Observable, catchError, map, of, startWith } from 'rxjs';
import { AppState } from './interface/app-state';
import { CustomResponse } from './interface/custom-response';
import { DataState } from './enum/data-state.enum';
import { Status } from './enum/status.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AppComponent implements OnInit {
  appState$: Observable<AppState<CustomResponse>>;
  readonly DataState = DataState;
  readonly Status = Status;
  private filterSubject = new BehaviorSubject<string>('');
  private dataSubject = new BehaviorSubject<CustomResponse>(null);
  filterStatus$ = this.filterSubject.asObservable();

  constructor(private filamentService: FilamentService) { }

  ngOnInit(): void {

    this.appState$ = this.filamentService.filaments$
      .pipe(
        map(response => {
          this.dataSubject.next(response);
          return { dataState: DataState.LOADED_STATE, appData: response }
        }),
        startWith({ dataState: DataState.LOADING_STATE }),
        catchError((error: string) => {
          return of({ dataState: DataState.ERROR_STATE, error })
        })
      );
  }

  filterFilaments(status: Status): void {
    this.appState$ = this.filamentService.filter$(status, this.dataSubject.value)
      .pipe(
        map(response => {
          return { dataState: DataState.LOADED_STATE, appData: response}
        }),
        startWith({ dataState: DataState.LOADING_STATE, appData: this.dataSubject.value }),
        catchError((error: string) => {
          return of({ dataState: DataState.ERROR_STATE, error })
        })
      );
  }

}
