
class Cell{
		protected int x, y;

		// Координаты
		public Cell(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}

		// Изменение состояния
		public void cell_changes(Area f){
			if(f.getField((f.getTurn()+1)%2)[x][y].infectable())
				f.getField((f.getTurn()+1)%2)[x][y] = this;
		}

		// Возможность заражения
		public Boolean infectable(){
			return true;
		}

		// Вывод обычной клетки
		public void cell_output(){
			System.out.print(" ○");
		}
	

}
