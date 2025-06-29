package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Paciente;
import java.time.LocalDate;

public class TestePersistencia {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoFinalPU");
        EntityManager em = emf.createEntityManager();

        try {
            // criar paciente
            Paciente p = new Paciente();
            p.setNome("João da Silva");
            p.setTelefone("51999999999");
            p.setCpf("02909221290");
            p.setEmail("joao@email.com");
            p.setDataNascimento(LocalDate.of(1990, 5, 15));
            p.setEndereco("Rua das Flores, 123");

            // iniciar transação
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

            System.out.println("Paciente salvo com sucesso! ID: " + p.getId());

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
