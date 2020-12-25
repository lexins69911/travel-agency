import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { NbMenuItem } from '@nebular/theme';

@Component({
    selector: 'app-admin-hotels',
    templateUrl: './admin-hotels.component.html',
    styleUrls: ['./admin-hotels.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdminHotelsComponent {}
