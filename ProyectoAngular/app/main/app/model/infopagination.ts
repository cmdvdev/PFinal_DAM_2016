export class InfoPagination {
  
  constructor(
    public numOfPages:number,
    public actualPage:number,
    public pageSize:number,
    public actualPageSize:number,
    public totalElements:number,
    public last:boolean,
    public first:boolean
  ){}
}