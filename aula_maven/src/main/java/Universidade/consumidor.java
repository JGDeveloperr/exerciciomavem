package Universidade;

import java.util.ArrayList;

public class consumidor {

	public static void main(String[] args) {
		//ArrayList<intercurso> cursos = new ArrayList<intercurso>();
		
		//instanciar um bacharelado;
		Bacharelado BSI = new Bacharelado();
		BSI.nome_curso = "BSI";
		BSI.carga_horaria = 3600;
		BSI.valor_parcela = 1200;
		
		//instanciar um bacharelado com odonto;
		bacharelado_laboratorio ODONTO = new bacharelado_laboratorio();
		ODONTO.nome_curso = "Odonto";
		ODONTO.carga_horaria = 4500;
		ODONTO.valor_parcela = 5000;
		ODONTO.custo_lab = 1000;

		
		bacharelado_laboratorio VETERINARIA = new bacharelado_laboratorio();
		VETERINARIA.nome_curso = "vet";
		VETERINARIA.carga_horaria = 3800;
		VETERINARIA.valor_parcela = 2500;
		VETERINARIA.custo_lab = 800;
		
		
		//adicionar um curso na lista_bacharelado
		//cursos.add(BSI);
		//cursos.add(ODONTO);
		//cursos.add(VETERINARIA);
		
		/*
		System.out.println(cursos.size());
		for(int i=0;i<cursos.size();i++) {
			System.out.println(cursos.get(i).GetNome_do_Curso());
			}
		*/
		
		Estudante novo;
		novo = new Estudante();
		
		novo.cpf="123";
		novo.email="luiz@gmail.com";
		novo.nome= "luiz";
		novo.matricula="222";
		
		
		
		novo.adicionarCurso(VETERINARIA);
		novo.adicionarCurso(ODONTO);
		
		
		//System.out.println(novo.GetNome_do_Curso());
		//System.out.println(novo.GetCusto_do_Curso());
		//System.out.println(novo.getValortotal());
		
		
		
		
		
		
		
		
		
	}

}
