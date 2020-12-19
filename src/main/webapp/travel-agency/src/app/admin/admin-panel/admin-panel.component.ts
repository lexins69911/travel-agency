import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { NbMenuItem } from '@nebular/theme';

@Component({
    selector: 'app-admin-panel',
    templateUrl: './admin-panel.component.html',
    styleUrls: ['./admin-panel.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdminPanelComponent {
    items: NbMenuItem[] = [
        {
            title: 'Отели',
            link: './hotels',
        },
        {
            title: 'Туры',
            link: './tours',
        },
        { title: 'Страны', link: './countries' },
        { title: 'Услуги', link: './services' },
    ];
}
