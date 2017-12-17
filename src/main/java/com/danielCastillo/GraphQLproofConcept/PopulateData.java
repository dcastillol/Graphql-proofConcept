package com.danielCastillo.GraphQLproofConcept;

import com.danielCastillo.GraphQLproofConcept.entities.Director;
import com.danielCastillo.GraphQLproofConcept.entities.Film;
import com.danielCastillo.GraphQLproofConcept.repositories.DirectorRepository;
import com.danielCastillo.GraphQLproofConcept.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

@Component
public class PopulateData {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @PostConstruct
    private void createData(){

        Director director1 = new Director();
        director1.setAge(63);
        director1.setName("James");
        director1.setSurname("Cameron");
        director1.setPhone("698531564");

        Director director2 = new Director();
        director2.setAge(94);
        director2.setName("Stan");
        director2.setSurname("Lee");
        director2.setPhone("456987236");


        Director director3 = new Director();
        director3.setAge(68);
        director3.setName("Pedro");
        director3.setSurname("Almodovar");
        director3.setPhone("987532165");

        director1 = directorRepository.save(director1);
        director2 = directorRepository.save(director2);
        director3 = directorRepository.save(director3);

        Film terminator = new Film();

        terminator.setTitle("Terminator");
        terminator.setDirector(director1);
        terminator.setPublishAt(new Date(467593200000L));
        terminator.setSinopsis("Los Ángeles, año 2029. Las máquinas dominan el mundo. Los rebeldes que luchan contra ellas tienen como líder a John Connor, un hombre que nació en los años ochenta. Para acabar con la rebelión, las máquinas deciden enviar al pasado a un robot -Terminator- cuya misión será eliminar a Sarah Connor, la madre de John, e impedir así su nacimiento.");

        Film titanic = new Film();
        titanic.setTitle("Titanic");
        titanic.setDirector(director1);
        titanic.setPublishAt(new Date(882486000000L));
        titanic.setSinopsis("Jack (DiCaprio), un joven artista, gana en una partida de cartas un pasaje para viajar a América en el Titanic, el transatlántico más grande y seguro jamás construido. A bordo conoce a Rose (Kate Winslet), una joven de una buena familia venida a menos que va a contraer un matrimonio de conveniencia con Cal (Billy Zane), un millonario engreído a quien sólo interesa el prestigioso apellido de su prometida. Jack y Rose se enamoran, pero el prometido y la madre de ella ponen todo tipo de trabas a su relación. Mientras, el gigantesco y lujoso transatlántico se aproxima hacia un inmenso iceberg.");

        Film spiderman = new Film();
        spiderman.setTitle("Spider-man");
        spiderman.setDirector(director2);
        spiderman.setPublishAt(new Date(1020376800000L));
        spiderman.setSinopsis("Tras la muerte de sus padres, Peter Parker, un tímido estudiante, vive con su tía May y su tío Ben. Precisamente debido a su retraimiento no es un chico muy popular en el instituto. Un día le muerde una araña que ha sido modificada genéticamente; a la mañana siguiente, descubre estupefacto que posee la fuerza y la agilidad de ese insecto. Las aventuras del hombre araña se basan en el famoso cómic de Stan Lee y Steve Ditko.");


        Film ironman = new Film();
        ironman.setTitle("Iron-man");
        ironman.setDirector(director2);
        ironman.setPublishAt(new Date(1209506400000L));
        ironman.setSinopsis("El multimillonario fabricante de armas Tony Stark (Robert Downey Jr.) debe enfrentarse a su turbio pasado después de sufrir un accidente con una de sus armas. Equipado con una armadura de última generación tecnológica, se convierte en \"El hombre de hierro\", un héroe que se dedica a combatir el mal en todo el mundo.");

        Film losAmantesPasajeros = new Film();
        losAmantesPasajeros.setTitle("Los amantes pasajeros");
        losAmantesPasajeros.setDirector(director3);
        losAmantesPasajeros.setPublishAt(new Date(1362697200000L));
        losAmantesPasajeros.setSinopsis("Un grupo de estrafalarios pasajeros viaja de Madrid a Ciudad de México en un avión cuya tripulación es absolutamente esperpéntica. Durante el vuelo, una grave avería hace que los pasajeros de clase business, al verse inevitablemente al borde de la muerte, se sientan inclinados a revelar los asuntos más íntimos de su vida. Todo ello desembocará en una comedia caótica y disparatada.");

        Film volver = new Film();
        volver.setTitle("Volver");
        volver.setDirector(director3);
        volver.setPublishAt(new Date(1141945200000L));
        volver.setSinopsis("Raimunda (Penélope Cruz) es manchega, pero vive en Madrid. Está casada con un obrero en paro (Antonio de la Torre) y tiene una hija adolescente (Yohana Cobo). Su hermana Sole (Lola Dueñas) se gana la vida como peluquera. Ambas echan de menos a su madre (Carmen Maura), que murió en un incendio. Pero, inesperadamente, la madre se presenta en casa de su hermana (Lampreave); después va a ver a Sole, a Raimunda y a Agustina (Portillo), una vecina del pueblo.");



        filmRepository.save(terminator);
        filmRepository.save(titanic);
        filmRepository.save(spiderman);
        filmRepository.save(ironman);
        filmRepository.save(losAmantesPasajeros);
        filmRepository.save(volver);

    }
}
