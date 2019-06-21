import { Component, OnInit } from '@angular/core';
import { LogService } from 'src/app/service/data/log.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log',
  templateUrl: './log.component.html',
  styleUrls: ['./log.component.css']
})
export class LogComponent implements OnInit {

  private logs;

  constructor(
    private logService: LogService,
    private route: Router,
  ) { }

  ngOnInit() {
    this.logService.getLogs().subscribe(
      data => {
        this.logs = data;
      }
    );
  }

  public navigate(direction,id) {
    if(id != null) {
      this.route.navigate([direction,id]);
    } else {
      this.route.navigate([direction]);
    }
  }

}
