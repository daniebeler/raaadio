import { Component, OnInit } from '@angular/core';
import { Controls } from 'src/app/models/controls';
import { Station } from 'src/app/models/station';
import { AudioService } from 'src/app/services/audio.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss'],
})
export class PlayerComponent implements OnInit {

  controls: Controls | null = null

  constructor(
    private audioService: AudioService
  ) { }

  ngOnInit() {
    this.audioService.getCurrentPlaying().subscribe(currentPlaying => {
      this.controls = currentPlaying
    })
  }

  pause() {
    this.audioService.pause()
  }

  play() {
    this.audioService.play()
  }

}
