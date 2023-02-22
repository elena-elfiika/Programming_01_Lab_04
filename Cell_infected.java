import java.util.Random;

class Cell_infected extends Cell_immuned{
	public Cell_infected(int x, int y){
		super(x,y);
		time = 6;
	}
	
	// Изменение состояния
	@Override
	public void cell_changes(Area f){					
		time -=1;
		if(time == 0){
			f.getField((f.getTurn()+1)%2)[x][y] = new Cell_immuned(x,y);
		}else{
			f.getField((f.getTurn()+1)%2)[x][y] = this;
			infect(f);
		}
	}
	
	// Вывод зараженной клетки
	@Override
	public void cell_output(){							
		System.out.print(" ×");
	}
	
	// Заражение
	private void infect(Area area){						
		Random r = new Random(); 
		int start = r.nextInt(8), id,x_=x,y_=y,interation=(area.getTurn()+1)%2;
		for (int k=0;k<8;k++){
			if(r.nextBoolean()){
				id = (k+start)%8;
				/*076*/
				/*1x5*/
				/*234*/
				switch(id){
					case 0:
						x_=x-1;
						y_=y-1;						
						break;
					case 1:
						x_=x-1;
						y_=y;						
						break;
					case 2:
						x_=x-1;
						y_=y+1;						
						break;
					case 3:
						x_=x;
						y_=y+1;						
						break;
					case 4:
						x_=x+1;
						y_=y+1;						
						break;
					case 5:
						x_=x+1;
						y_=y;						
						break;
					case 6:
						x_=x+1;
						y_=y-1;
						break;
					case 7:
						x_=x;
						y_=y-1;
						break;	
				}
				
				if(area.getField(interation)[x_][y_].infectable()){
					area.getField(interation)[x_][y_] = new Cell_infected(x_,y_);
					break;
					}
			}
		}
	}

}
