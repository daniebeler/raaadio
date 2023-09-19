import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Station } from 'src/app/models/station';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.page.html',
  styleUrls: ['./genre.page.scss'],
})
export class GenrePage implements OnInit {

  genre: string = '';
  stations: Station[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private apiService: ApiService,
    private router: Router
  ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    this.genre = id ?? 'Failed to receive genre';
    this.apiService.getStationsOfGenre(this.genre).subscribe(res => {
      this.stations = res;
    })
  }

  gotoGenres() {
    this.router.navigate(['/genres'])
  }

}
