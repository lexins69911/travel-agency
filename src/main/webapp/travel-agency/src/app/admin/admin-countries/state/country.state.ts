import { Injectable } from '@angular/core';
import { Action, State, StateContext } from '@ngxs/store';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AdminApiService } from '../../admin-api.service';
import { Country } from './country.model';

type CountriesStateModel = Country[];

export class LoadCountries {
    static readonly type = '[Countries] load countries';
}

@State<CountriesStateModel>({
    name: 'countries',
    defaults: [],
})
@Injectable()
export class CountriesState {
    constructor(private readonly api: AdminApiService) {}

    @Action(LoadCountries)
    loadCountries(ctx: StateContext<CountriesStateModel>): Observable<Country[]> {
        return this.api.loadCountries().pipe(tap((countries) => ctx.setState(countries)));
    }
}
