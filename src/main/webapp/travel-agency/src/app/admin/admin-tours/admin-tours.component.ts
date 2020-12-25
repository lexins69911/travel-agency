import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { NbMenuItem } from '@nebular/theme';

@Component({
    selector: 'app-admin-tours',
    templateUrl: './admin-tours.component.html',
    styleUrls: ['./admin-tours.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdminToursComponent {}
