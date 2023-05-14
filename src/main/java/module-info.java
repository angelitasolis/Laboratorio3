module com.mariangel.lab3 {
requires java.base;
requires java.compiler;
requires java.desktop;
requires java.instrument;
requires java.logging;
requires java.management;
requires java.naming;
requires java.persistence;
requires java.sql;
requires java.xml;
requires javafx.base;
requires javafx.controls;
requires javafx.fxml;
requires javafx.graphics;
requires jdk.unsupported;
requires jdk.xml.dom;
requires org.eclipse.persistence.asm;
requires org.eclipse.persistence.core;
requires org.eclipse.persistence.jpa;
requires org.eclipse.persistence.jpa.jpql;
requires org.eclipse.persistence.moxy;
    opens com.mariangel.lab3 to javafx.fxml;
    exports com.mariangel.lab3;
}
