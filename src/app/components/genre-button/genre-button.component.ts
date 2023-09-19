import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Genre } from 'src/app/interfaces/genre';

@Component({
  selector: 'app-genre-button',
  templateUrl: './genre-button.component.html',
  styleUrls: ['./genre-button.component.scss'],
})
export class GenreButtonComponent implements OnInit {

  @Input() genre!: Genre

  constructor(
    private router: Router
  ) { }

  ngOnInit() {}

  gotoGenre() {
    this.router.navigate(['/genres/', this.genre.tag])
  }

}
