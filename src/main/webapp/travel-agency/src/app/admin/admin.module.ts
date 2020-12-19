import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {
    NbButtonModule,
    NbCardModule,
    NbIconModule,
    NbInputModule,
    NbLayoutModule,
    NbListModule,
    NbMenuModule,
    NbSidebarModule,
} from '@nebular/theme';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { AdminCountriesComponent } from './admin-countries/admin-countries.component';
import { AdminHotelsComponent } from './admin-hotels/admin-hotels.component';
import { AdminToursComponent } from './admin-tours/admin-tours.component';
import { NgxsModule } from '@ngxs/store';
import { CountriesState } from './admin-countries/state/country.state';
import { EditCountryComponent } from './admin-countries/edit-country/edit-country.component';
import { CountryResolver } from './admin-countries/edit-country/country.resolver';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
    declarations: [AdminPanelComponent, AdminCountriesComponent, AdminHotelsComponent, AdminToursComponent, EditCountryComponent],
    imports: [
        CommonModule,
        RouterModule.forChild([
            {
                path: '',
                component: AdminPanelComponent,
                children: [
                    {
                        path: 'hotels',
                        component: AdminHotelsComponent,
                    },
                    {
                        path: 'tours',
                        component: AdminToursComponent,
                    },
                    {
                        path: 'countries',
                        component: AdminCountriesComponent,
                    },
                    {
                        path: 'countries/:id',
                        component: EditCountryComponent,
                        resolve: {
                            country: CountryResolver,
                        },
                    },
                ],
            },
        ]),
        NbMenuModule,
        NbLayoutModule,
        NbSidebarModule,
        NbListModule,
        NbCardModule,
        NbInputModule,
        NbButtonModule,
        NbIconModule,
        ReactiveFormsModule,
        NgxsModule.forFeature([CountriesState]),
    ],
    providers: [CountryResolver],
})
export class AdminModule {}
