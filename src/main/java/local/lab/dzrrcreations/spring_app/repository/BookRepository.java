package local.lab.dzrrcreations.spring_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import local.lab.dzrrcreations.spring_app.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
