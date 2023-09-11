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

  play() {
    this.audio.play()
    let soos = this.currentPlaying.getValue()
    if (soos) {
      soos.playing = true
      this.currentPlaying.next(soos)
    }
  }

  pause() {
    this.audio.pause()
    let soos = this.currentPlaying.getValue()
    if (soos) {
      soos.playing = false
      this.currentPlaying.next(soos)
    }
  }
}
