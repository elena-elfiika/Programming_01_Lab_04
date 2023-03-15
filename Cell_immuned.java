class Cell_immuned extends Cell{
	protected int time;

	public Cell_immuned(int x, int y){
		super(x,y);
		time = 4;
	}

	@Override
	public boolean infectable() {
		return false;
	}

	// Изменение состояния
	@Override
	public void cell_changes(Area f) {							
		time -= 1;
		if(time == 0){
			f.getField((f.getTurn()+1)%2)[x][y] = new Cell(x,y);
		}else{
			f.getField((f.getTurn()+1)%2)[x][y] = this;
		}
	}

	// Вывод имунной клеткич
	@Override
	public void cell_output(){									
		System.out.print(" •");
	}
}
