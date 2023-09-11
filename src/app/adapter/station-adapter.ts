import { Station } from "../models/station";
import { Adapter } from "./adapter";

export class StationAdapter implements Adapter<Station> {

  adapt(item: any): Station {
    item.name = item.name ?? ''
    item.url = item.url ?? ''
    item.icon = item.favicon ?? ''  // Default image einsetzen
    return new Station(item.name, item.url, item.icon)
  };
}
