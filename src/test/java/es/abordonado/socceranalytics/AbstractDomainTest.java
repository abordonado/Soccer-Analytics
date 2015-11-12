package es.abordonado.socceranalytics;


import com.github.springtestdbunit.annotation.DatabaseSetup;


@DatabaseSetup("/dbtest/domainTest.xml")
public abstract class AbstractDomainTest extends AbstractTest {
}
