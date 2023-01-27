import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import SwiperCore, { Keyboard, Pagination, Navigation, Virtual } from 'swiper';

SwiperCore.use([Keyboard, Pagination, Navigation, Virtual]);

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss', ],
  encapsulation: ViewEncapsulation.None
})
export class HomePage implements OnInit {

  topGermanStations: any[] = [];

  constructor(
    private apiService: ApiService
  ) {}

  ngOnInit(): void {
    this.apiService.getRequests().subscribe(res => {
      console.log(res);
      this.topGermanStations = res;
    })
  }

}
