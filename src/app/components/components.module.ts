import { NgModule } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { PlayerComponent } from './player/player.component';

@NgModule({
  declarations: [
    PlayerComponent
  ],
  exports: [
    PlayerComponent
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
