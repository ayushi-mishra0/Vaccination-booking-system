package com.example.vaccinationbookingsystem.services;

 import com.example.vaccinationbookingsystem.Dtos.Requestdtos.RequestDose;
        import com.example.vaccinationbookingsystem.Dtos.Responsedtos.PersonResponse;
        import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseDose;
        import com.example.vaccinationbookingsystem.Enum.DoseType;
        import com.example.vaccinationbookingsystem.Exceptions.PersonNotPresent;
        import com.example.vaccinationbookingsystem.Model.Dose;
        import com.example.vaccinationbookingsystem.Model.Person;
        import com.example.vaccinationbookingsystem.repository.DoseRepo;
        import com.example.vaccinationbookingsystem.repository.PersonRepo;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;
        import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class DoseService {
    @Autowired
    DoseRepo doseRepo;
    @Autowired
    PersonRepo personRepo;
    public ResponseDose addDose(RequestDose requestDose) {
        Optional<Person> p=personRepo.findById(requestDose.getPersonId());
        if(p.isEmpty()){
            throw new RuntimeException("invalid id");
        }
        Person person=p.get();
        if(person.isDose1Taken()==true){
            throw new RuntimeException("Already taken");
        }
        person.setDose1Taken(true);
        Dose dose=new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(requestDose.getDoseType());
        dose.setPerson(person);
        person.getDosesTaken().add(dose);
        Person savedPerson=personRepo.save(person);
        Dose savedDose=savedPerson.getDosesTaken().get(0);
        ResponseDose dd=new ResponseDose();
        dd.setDoseType(dose.getDoseType());
        dd.setDate(savedDose.getVaccinationDate());
        dd.setDoseId(dose.getDoseId());

        PersonResponse pp=new PersonResponse();
        pp.setAge(savedPerson.getAge());
        pp.setName(savedPerson.getName());
        pp.setAge(savedPerson.getAge());
        pp.setEmailId(savedPerson.getEmailId());
        pp.setMessage("i am vaccinated");

        dd.setPersonResponse(pp);

        return dd;
    }

    public List<DoseType> getAlldoses(int id) {
        Optional<Person> p=personRepo.findById(id);
        if(p.isEmpty()){
            throw new PersonNotPresent();
        }
        Person curr=p.get();
        List<Dose> doses=curr.getDosesTaken();
        List<DoseType> types=new ArrayList<>();
        for(Dose d:doses){
            types.add(d.getDoseType());
        }
        return types;
    }

    public ResponseDose getDose2(RequestDose requestDose) {
        Optional<Person> p=personRepo.findById(requestDose.getPersonId());
        if(p.isEmpty()){
            throw new PersonNotPresent();
        }
        Person person=p.get();
        if(person.isDose1Taken()==false){
            throw new RuntimeException("take dose 1 first");
        }
        person.setDose2Taken(true);
        Dose dose=new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(requestDose.getDoseType());
        dose.setPerson(person);
        person.getDosesTaken().add(dose);
        Person savedPerson=personRepo.save(person);

        ResponseDose dd=new ResponseDose();
        dd.setDoseType(dose.getDoseType());
        dd.setDate(dose.getVaccinationDate());
        dd.setDoseId(dose.getDoseId());

        PersonResponse pp=new PersonResponse();
        pp.setAge(savedPerson.getAge());
        pp.setName(savedPerson.getName());
        pp.setAge(savedPerson.getAge());
        pp.setEmailId(savedPerson.getEmailId());
        pp.setMessage("you have vaccinated successfully dose2");

        dd.setPersonResponse(pp);

        return dd;
    }
}