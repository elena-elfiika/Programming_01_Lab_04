
class Cell{
		protected int x, y, changes;

		// Координаты
		public Cell(int x, int y){
			this.x = x;
			this.y = y;
			this.changes = 0;
		}

		public int getX(){
			return x;
		}

		public int getY(){
			return y;
		}

		// Изменение состояния
		public void cell_changes(Area f){
			if(f.getField((f.getTurn()))[x][y].changes == 0){
				f.getField((f.getTurn()))[x][y] = this;
			}	
		}

		// Вывод обычной клетки
		public void cell_output(){
			System.out.print(" ○");
		}
	

}
