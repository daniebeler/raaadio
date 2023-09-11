import { Component, OnInit } from '@angular/core';
import { Station } from 'src/app/models/station';
import { AudioService } from 'src/app/services/audio.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss'],
})
export class PlayerComponent implements OnInit {

  currentPlayingStation: Station | null = null

  constructor(
    private audioService: AudioService
  ) { }

  ngOnInit() {
    this.audioService.getCurrentPlaying().subscribe(currentPlaying => {
      console.log(currentPlaying?.url)
      this.currentPlayingStation = currentPlaying
    })
  }

}
