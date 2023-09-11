import { Station } from "./station"

export class Controls {

  public playing: boolean = false
  public station: Station

  constructor(station: any) {
    this.station = station
  }
}
