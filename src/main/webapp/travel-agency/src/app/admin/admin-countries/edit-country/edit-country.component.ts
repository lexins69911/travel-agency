import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { pluck, tap } from 'rxjs/operators';

import { Country } from '../state/country.model';

@Component({
    selector: 'app-edit-country',
    templateUrl: './edit-country.component.html',
    styleUrls: ['./edit-country.component.scss'],
})
export class EditCountryComponent {
    country$: Observable<Country> = this.route.data.pipe(pluck('country'), tap(this.initForm.bind(this)));
    form: FormGroup | undefined;

    constructor(private route: ActivatedRoute, private fb: FormBuilder) {}

    initForm({ name }: Country) {
        this.form = this.fb.group({
            name: [name, Validators.required],
        });
    }
}
