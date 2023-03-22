
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

		// Заражаемость
		public boolean infectable() {
			return true;
		}

		// Разумно делать запрос с ответом да/нет через отдельный метод
		// Изменение состояния
		public void cell_changes(Area f){
			if(infectable()){
				f.getField((f.getTurn()))[x][y] = this;
			}	
		}

		// Вывод обычной клетки
		public void cell_output(){
			System.out.print(" ○");
		}
	

}
