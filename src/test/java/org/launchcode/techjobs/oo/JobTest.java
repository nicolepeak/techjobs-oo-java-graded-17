package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

     @Test
    public void testSettingJobId() {
         Job testJob1 = new Job();
         Job testJob2 = new Job();
         assertNotEquals(testJob1.getId(), testJob2.getId());
     }

     @Test
    public void testJobConstructorSetsAllFields() {
         Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

         assertTrue(testJob1 instanceof Job);
         assertEquals("Product tester", testJob1.getName());

         assertTrue(testJob1.getEmployer() instanceof Employer);
         assertEquals("ACME", testJob1.getEmployer().getValue());

         assertTrue(testJob1.getLocation() instanceof Location);
         assertEquals("Desert", testJob1.getLocation().getValue());

         assertTrue(testJob1.getPositionType() instanceof PositionType);
         assertEquals("Quality control", testJob1.getPositionType().getValue());

         assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
         assertEquals("Persistence", testJob1.getCoreCompetency().getValue());

     }

     @Test
    public void testJobsForEquality(){
         Job job1 = new Job ("Web Developer", new Employer("Google"), new Location("St. Louis"),
                 new PositionType("Software Engineer"), new CoreCompetency("Java"));
         Job job2 = new Job ("Web Developer", new Employer("Google"), new Location("St. Louis"),
                 new PositionType("Software Engineer"), new CoreCompetency("Java"));

         assertFalse(job1.equals(job2));
     }

     @Test
    public void testToStringStartsAndEndsWithNewLine() {
         Job job1 = new Job ("Web Developer", new Employer("Google"), new Location("St. Louis"),
                 new PositionType("Software Engineer"), new CoreCompetency("Java"));

         String jobString = job1.toString();

         assertTrue(jobString.startsWith(System.lineSeparator()));
         assertTrue(jobString.endsWith(System.lineSeparator()));
     }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Web Developer", new Employer("Google"), new Location("St. Louis"),
                new PositionType("Software Engineer"), new CoreCompetency("Java"));

        String jobString = job1.toString();

        assertTrue(jobString.contains("ID: " + job1.getId()));
        assertTrue(jobString.contains("Name: " + job1.getName()));
        assertTrue(jobString.contains("Employer: " + job1.getEmployer().getValue()));
        assertTrue(jobString.contains("Location: " + job1.getLocation().getValue()));
        assertTrue(jobString.contains("Position Type: " + job1.getPositionType().getValue()));
        assertTrue(jobString.contains("Core Competency: " + job1.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        String jobString = job1.toString();

        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }
}
