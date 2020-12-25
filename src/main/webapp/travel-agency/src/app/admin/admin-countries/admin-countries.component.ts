import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { NbMenuItem } from '@nebular/theme';
import { Select, Store } from '@ngxs/store';
import { Observable } from 'rxjs';
import { Country } from './state/country.model';
import { CountriesState, LoadCountries } from './state/country.state';

@Component({
    selector: 'app-admin-countries',
    templateUrl: './admin-countries.component.html',
    styleUrls: ['./admin-countries.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdminCountriesComponent implements OnInit {
    @Select(CountriesState) countries$: Observable<Country[]> | undefined;

    constructor(private store: Store) {}

    ngOnInit() {
        this.store.dispatch(new LoadCountries());
    }
}
