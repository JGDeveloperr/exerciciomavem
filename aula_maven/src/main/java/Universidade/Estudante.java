package Universidade;

import java.util.ArrayList;

public class Estudante implements intercurso{
	String matricula;
	String cpf;
	String nome;
	String email;
	
	private ArrayList<intercurso> cursosestudante = new ArrayList<intercurso>();
	


	public void adicionarCurso(intercurso curso) {
        cursosestudante.add(curso);
    }
	
	
 	public double GetCusto_do_Curso() {
		
		double valorcurso =0;
		
		for(intercurso x : cursosestudante) {
				
		 valorcurso = x.GetCusto_do_Curso();
		
		}
		return valorcurso;
	}
	
	public String GetNome_do_Curso() {
		
		String nomecursos ="";
		
		for(intercurso x : cursosestudante){
			
			nomecursos = nomecursos + x.GetNome_do_Curso() + "\n";
			
			
		}
		
		return nomecursos;
	}


	public double getValortotal() {
		
		double valortotal = 0;
		
		for( intercurso x : cursosestudante) {
			
			valortotal = valortotal + x.GetCusto_do_Curso();
			
		}
		
		return valortotal;
		
	}
	

}