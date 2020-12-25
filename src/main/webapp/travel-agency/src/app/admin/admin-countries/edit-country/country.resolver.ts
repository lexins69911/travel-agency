import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router } from '@angular/router';
import { EMPTY, Observable } from 'rxjs';
import { option } from 'fp-ts';
import { pipe } from 'fp-ts/lib/function';

import { AdminApiService } from '../../admin-api.service';
import { Country } from '../state/country.model';

@Injectable()
export class CountryResolver implements Resolve<Country> {
    constructor(private readonly api: AdminApiService, private router: Router) {}

    resolve(route: ActivatedRouteSnapshot): Observable<Country> | Observable<never> {
        return pipe(
            option.fromNullable(route.paramMap.get('id')),
            option.map(parseInt),
            option.chain((s) => (isNaN(s) ? option.none : option.some(s))),
            option.fold(() => {
                this.router.navigate(['../']);

                return EMPTY;
            }, this.api.getCountry.bind(this))
        );
    }
}
