import { Component, Input, OnInit } from '@angular/core';
import { Station } from 'src/app/models/station';
import { AudioService } from 'src/app/services/audio.service';

@Component({
  selector: 'app-station',
  templateUrl: './station.component.html',
  styleUrls: ['./station.component.scss'],
})
export class StationComponent implements OnInit {

  @Input() station!: Station

  constructor(
    private audioService: AudioService
  ) { }

  ngOnInit() {}

  clickedStation(station: any) {
    this.audioService.updateStation(station)
  }

}
