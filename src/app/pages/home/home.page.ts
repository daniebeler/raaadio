import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { Station } from 'src/app/models/station';
import { ApiService } from 'src/app/services/api.service';
import SwiperCore, { Keyboard, Pagination, Navigation, Virtual } from 'swiper';

SwiperCore.use([Keyboard, Pagination, Navigation, Virtual]);

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss',],
  encapsulation: ViewEncapsulation.None
})
export class HomePage implements OnInit {

  topGermanStations: Station[] = [];
  topStationsWorldwide: Station[] = [];

  constructor(
    private apiService: ApiService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.apiService.getStationsByCountry('AT').subscribe(res => {
      this.topGermanStations = res;
    })

    this.apiService.getPopularStations().subscribe(res => {
      this.topStationsWorldwide = res
    })

    this.apiService.getMostPopularTags().subscribe(res => {
    })
  }

  gotoGenres() {
    this.router.navigate(['/genres'])
  }

  gotoCountries() {
    this.router.navigate(['/countries'])
  }
}
