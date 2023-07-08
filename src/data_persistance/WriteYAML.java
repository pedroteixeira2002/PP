package data_persistance;

import cbl.PortfolioImp;
import cbl.ProjectImp;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;

import java.io.FileWriter;
import java.io.IOException;

public class WriteYAML {
    public WriteYAML() {
    }

    public void writeYAML(PortfolioImp portfolioTmp) throws IOException {
        StringBuilder yamlData = new StringBuilder();

        for (Edition editionTmp : portfolioTmp.getEditions()) {
            if (editionTmp == null)
                break;
            yamlData.append("edition:\n");
            yamlData.append("  name: ").append(editionTmp.getName()).append("\n");
            yamlData.append("  start: ").append(editionTmp.getStart().toString()).append("\n");
            yamlData.append("  end: ").append(editionTmp.getEnd().toString()).append("\n");
            yamlData.append("  status: ").append(editionTmp.getStatus().toString()).append("\n");
            yamlData.append("  number_of_projects: ").append(editionTmp.getNumberOfProjects()).append("\n");

            int projectIndex = 1;
            for (Project projectTmp : editionTmp.getProjects()) {
                if (projectTmp == null)
                    break;
                yamlData.append("project").append(projectIndex++).append(":\n");
                yamlData.append("  name: ").append(projectTmp.getName()).append("\n");
                yamlData.append("  description: ").append(projectTmp.getDescription()).append("\n");
                yamlData.append("  number_of_participants: ").append(projectTmp.getNumberOfParticipants()).append("\n");
                yamlData.append("  number_of_students: ").append(projectTmp.getNumberOfStudents()).append("\n");
                yamlData.append("  number_of_facilitators: ").append(projectTmp.getNumberOfFacilitators()).append("\n");
                yamlData.append("  number_of_partners: ").append(projectTmp.getNumberOfPartners()).append("\n");

                int participantIndex = 1;
                for (Participant participantTmp : ((ProjectImp) projectTmp).getParticipants()) {
                    if (participantTmp == null)
                        break;
                    yamlData.append("  participant").append(participantIndex++).append(":\n");
                    if (participantTmp instanceof Student) {
                        yamlData.append("    number: ").append(((Student) participantTmp).getNumber()).append("\n");
                        yamlData.append("    type: student\n");
                    } else if (participantTmp instanceof Facilitator) {
                        yamlData.append("    area_of_expertise: ").append(((Facilitator) participantTmp).getAreaOfExpertise()).append("\n");
                        yamlData.append("    type: facilitator\n");
                    } else if (participantTmp instanceof Partner) {
                        yamlData.append("    type: partner\n");
                        yamlData.append("    website: ").append(((Partner) participantTmp).getWebsite()).append("\n");
                        yamlData.append("    vat: ").append(((Partner) participantTmp).getVat()).append("\n");
                    }

                    yamlData.append("    name: ").append(participantTmp.getName()).append("\n");
                    yamlData.append("    email: ").append(participantTmp.getEmail()).append("\n");
                    yamlData.append("    contact: ").append(participantTmp.getContact().toString()).append("\n");
                    yamlData.append("    institution: ").append(participantTmp.getInstituition().toString()).append("\n");
                }

                int taskIndex = 1;
                for (Task taskTmp : projectTmp.getTasks()) {
                    if (taskTmp == null)
                        break;
                    yamlData.append("  task").append(taskIndex++).append(":\n");
                    yamlData.append("    title: ").append(taskTmp.getTitle()).append("\n");
                    yamlData.append("    description: ").append(taskTmp.getDescription()).append("\n");
                    yamlData.append("    duration: ").append(taskTmp.getDuration()).append("\n");
                    yamlData.append("    start: ").append(taskTmp.getStart().toString()).append("\n");
                    yamlData.append("    end: ").append(taskTmp.getEnd().toString()).append("\n");
                    yamlData.append("    number of submissions: ").append(taskTmp.getNumberOfSubmissions()).append("\n");

                    int submissionIndex = 1;
                    for (Submission submissionTmp : taskTmp.getSubmissions()) {
                        if (submissionTmp == null)
                            break;
                        yamlData.append("    submission").append(submissionIndex++).append(":\n");
                        yamlData.append("      date: ").append(submissionTmp.getDate().toString()).append("\n");
                        yamlData.append("      student: ").append(submissionTmp.getStudent()).append("\n");
                        yamlData.append("      text: ").append(submissionTmp.getText()).append("\n");
                    }
                }
            }
        }

        FileWriter writer = new FileWriter("yaml_files//export.yaml");
        writer.write(yamlData.toString());
        writer.close();

        System.out.println("YAML file created: export.yaml");
    }
}
