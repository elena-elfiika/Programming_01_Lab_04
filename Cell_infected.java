import java.util.Random;

class Cell_infected extends Cell_immuned{
	public Cell_infected(int x, int y){
		super(x,y);
		time = 5;
		changes = 2;
	}
	
	// Изменение состояния
	@Override
	public void cell_changes(Area f){					
		
		//Время вышло, клетка становится имунной.
		if(time == 0){
			f.getField(f.getTurn())[x][y] = new Cell_immuned(x,y);
		//Время не вышло, клетка осталась зараженной. Заражает соседнюю.
		}else{
			f.getField(f.getTurn())[x][y] = this;
			infect(f);
		}
		
		time -=1;
	}
	
	// Вывод зараженной клетки
	@Override
	public void cell_output(){							
		System.out.print(" ×");
	}
	
	// Заражение
	private void infect(Area area){
		Random r = new Random();
		int rand = r.nextInt(8);
		int x_i = x, y_i = y, interation=(area.getTurn());

		if(r.nextBoolean()){
			/*076*/
			/*1x5*/
			/*234*/
			
			switch(rand%8){
				case 0:
					x_i=x-1;
					y_i=y-1;	
					break;
				case 1:
					x_i=x-1;
					y_i=y;						
					break;
				case 2:
					x_i=x-1;
					y_i=y+1;						
					break;
				case 3:
					x_i=x;
					y_i=y+1;
					break;
				case 4:
					x_i=x+1;
					y_i=y+1;						
					break;
				case 5:
					x_i=x+1;
					y_i=y;						
					break;
				case 6:
					x_i=x+1;
					y_i=y-1;
					break;
				case 7:
					x_i=x;
					y_i=y-1;
					break;	
				}

			if(area.getField(interation)[x_i][y_i].changes == 0){
				area.getField(interation)[x_i][y_i] = new Cell_infected(x_i,y_i);
			}
		}
	}
		
}
