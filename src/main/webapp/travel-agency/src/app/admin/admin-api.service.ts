import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

import { Country } from './admin-countries/state/country.model';

@Injectable({
    providedIn: 'root',
})
export class AdminApiService {
    constructor() {}

    loadCountries(): Observable<Country[]> {
        return of(
            Array.from({ length: 30 }).map((_, i) => ({
                id: i,
                name: i.toString(),
            }))
        ).pipe(delay(300));
    }

    getCountry(id: Country['id']): Observable<Country> {
        return of({
            id,
            name: '23',
        });
    }
}
