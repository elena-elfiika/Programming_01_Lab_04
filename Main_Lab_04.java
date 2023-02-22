public class Main_Lab_04 {
		public static void main(String[] args){ 
			
			//Количество запусков
			int kva = 42; 
			Area area = new Area();
			
			// Вывод состояний
			for (int i=0; i<kva; i++){
				System.out.println("\nTime: "+(i+1));
				area.play();
			}
		}
}
