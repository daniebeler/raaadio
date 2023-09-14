import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Station } from '../models/station';
import { Controls } from '../models/controls';

@Injectable({
  providedIn: 'root'
})
export class AudioService {

  private currentPlaying = new BehaviorSubject<Controls | null>(null);

  private audio = new Audio()

  constructor() {
    this.audio.addEventListener("play", fief => {
      this.startedPlaying()
    })

    this.audio.addEventListener("pause", fief => {
      this.startedPause()
    })
  }

  getCurrentPlaying(): Observable<Controls | null> {
    return this.currentPlaying
  }

  updateStation(newStation: Station) {
    let fief = this.currentPlaying.getValue() ?? new Controls(newStation)
    fief.station = newStation
    this.currentPlaying.next(fief)
    this.audio.src = fief.station.url
    this.play()
  }

  startedPlaying() {
    let soos = this.currentPlaying.getValue()
    if (soos) {
      soos.playing = true
      this.currentPlaying.next(soos)
    }
  }

  startedPause() {
    let soos = this.currentPlaying.getValue()
    if (soos) {
      soos.playing = false
      this.currentPlaying.next(soos)
    }
  }

  play() {
    this.audio.play()
  }

  pause() {
    this.audio.pause()
  }
}
