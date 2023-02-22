class Cell_immuned extends Cell{
	protected int time;

	public Cell_immuned(int x, int y){
		super(x,y);
		time = 4;
	}

	// Изменение состояния
	@Override
	public void cell_changes(Area f) {							
		time -=1;
		if(time == 0){
			f.getField((f.getTurn()+1)%2)[x][y] = new Cell(x,y);
			f.getField(f.getTurn())[x][y] = new Cell(x,y);
		}else{
			f.getField((f.getTurn()+1)%2)[x][y] = this;
		}
	}
	
	// Возможность заражения
	@Override
	public Boolean infectable(){								
		return false;
	}

	// Вывод имунной клеткич
	@Override
	public void cell_output(){									
		System.out.print(" •");
	}
}
