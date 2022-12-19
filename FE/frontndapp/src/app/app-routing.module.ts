import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './component/add/add.component';
import { EditComponent } from './component/edit/edit.component';
import { ListComponent } from './component/list/list.component';
import { ViewComponent } from './component/view/view.component';

const routes: Routes = [
  {path: 'employees', component: ListComponent},
  {path: 'create-employee', component: AddComponent},
  {path: '', redirectTo: 'employees', pathMatch: 'full'},
  {path: 'update-employee/:id', component: EditComponent},
  {path: 'employee-details/:id', component: ViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
