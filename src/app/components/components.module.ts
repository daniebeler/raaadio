import { NgModule } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { PlayerComponent } from './player/player.component';
import { StationComponent } from './station/station.component';

@NgModule({
  declarations: [
    PlayerComponent,
    StationComponent
  ],
  exports: [
    PlayerComponent,
    StationComponent
  ],
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    Geolocation
  ]
})
export class ComponentsModule { }
