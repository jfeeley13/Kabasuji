package entity;

public class RowColumn {
	int row, column;
	public RowColumn(int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public void setRow(int row){
		this.row = row;
	}
	
	public void setColumn(int column){
		this.column = column;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
	}
}
