import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Station } from 'src/app/models/station';
import { ApiService } from 'src/app/services/api.service';
import { AudioService } from 'src/app/services/audio.service';
import SwiperCore, { Keyboard, Pagination, Navigation, Virtual } from 'swiper';

SwiperCore.use([Keyboard, Pagination, Navigation, Virtual]);

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss', ],
  encapsulation: ViewEncapsulation.None
})
export class HomePage implements OnInit {

  topGermanStations: Station[] = [];

  constructor(
    private apiService: ApiService,
    private audioService: AudioService
  ) {}

  ngOnInit(): void {
    console.log('init')
    this.apiService.getRequests().subscribe(res => {
      console.log(res);
      this.topGermanStations = res;
    })
  }

  clickedStation(station: any) {
    console.log(station)
    this.audioService.updateStation(station)
  }

}
