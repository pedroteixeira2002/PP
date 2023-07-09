/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package data_persistance;

import Interfaces.Portfolio;
import ma02_resources.project.Project;
import participants.ParticipantImp;
import cbl.PortfolioImp;
import cbl.ProjectImp;

import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;

import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.FileWriter;
import java.io.IOException;

/**
 * Class responsible for writing the data to a JSON file
 */
public class WriteJSON {
    public WriteJSON() {
    }

    /**
     * Method that writes the data to a JSON file
     * @param portfolioTmp Portfolio to be written
     * @throws IOException Exception thrown in case of an error
     */
    public void writeJSON(PortfolioImp portfolioTmp) throws IOException {

        JSONObject jsonObject = new JSONObject();

        try {
            FileWriter fileWriter = new FileWriter("json_files\\export.json");

            JSONArray editionsArray = new JSONArray();

            for (Edition editionTmp : portfolioTmp.getEditions()) {
                if (editionTmp == null)
                    break;
                JSONObject edition = new JSONObject();
                edition.put("name", editionTmp.getName());
                edition.put("start", editionTmp.getStart().toString());
                edition.put("end", editionTmp.getEnd().toString());
                edition.put("status", editionTmp.getStatus().toString());
                edition.put("number_of_projects", editionTmp.getNumberOfProjects());

                JSONArray projectsArray = new JSONArray();

                for (Project projectTmp : editionTmp.getProjects()) {
                    if (projectTmp == null)
                        break;
                    JSONObject project = new JSONObject();
                    project.put("name", projectTmp.getName());
                    project.put("description", projectTmp.getDescription());
                    project.put("number_of_participants", projectTmp.getNumberOfParticipants());
                    project.put("number_of_students", projectTmp.getNumberOfStudents());
                    project.put("number_of_facilitators", projectTmp.getNumberOfFacilitators());
                    project.put("number_of_partners", projectTmp.getNumberOfPartners());

                    JSONArray projectParticipantsArray = new JSONArray();

                    for (Participant participantTmp : ((ProjectImp) projectTmp).getParticipants()) {
                        if (participantTmp == null)
                            break;
                        JSONObject participant = new JSONObject();
                        if (participantTmp instanceof Student) {
                            participant.put("number", ((Student) participantTmp).getNumber());
                            project.put("type", "student");
                        } else if (participantTmp instanceof Facilitator) {
                            participant.put("area_of_expertise", ((Facilitator) participantTmp).getAreaOfExpertise());
                            project.put("type", "facilitator");
                        } else if (participantTmp instanceof Partner) {
                            project.put("type", "partner");
                            participant.put("website", ((Partner) participantTmp).getWebsite());
                            participant.put("vat", ((Partner) participantTmp).getVat());
                        }

                        participant.put("name", participantTmp.getName());
                        participant.put("email", participantTmp.getEmail());
                        participant.put("contact", participantTmp.getContact().toString());
                        participant.put("institution", participantTmp.getInstituition().toString());

                        projectParticipantsArray.add(participant);
                    }

                    project.put("participants", projectParticipantsArray);

                    JSONArray tagsArray = new JSONArray();

                    for (String tagTmp : projectTmp.getTags()) {
                        if (tagTmp == null)
                            break;

                        tagsArray.add(tagTmp);
                    }

                    JSONArray tasksArray = new JSONArray();

                    for (Task taskTmp : projectTmp.getTasks()) {
                        if (taskTmp == null)
                            break;
                        JSONObject task = new JSONObject();
                        task.put("title", taskTmp.getTitle());
                        task.put("description", taskTmp.getDescription());
                        task.put("duration", taskTmp.getDuration());
                        task.put("start", taskTmp.getStart().toString());
                        task.put("end", taskTmp.getEnd().toString());
                        task.put("number of submissions", taskTmp.getNumberOfSubmissions());

                        JSONArray submissionsArray = new JSONArray();

                        for (Submission submissionTmp : taskTmp.getSubmissions()) {
                            if (submissionTmp == null)
                                break;
                            JSONObject submission = new JSONObject();
                            submission.put("date", submissionTmp.getDate().toString());
                            submission.put("student", submissionTmp.getStudent());
                            submission.put("text", submissionTmp.getText());

                            submissionsArray.add(submission);
                        }

                        task.put("submissions", submissionsArray);
                        tasksArray.add(task);
                    }

                    project.put("tasks", tasksArray);
                    projectsArray.add(project);
                }

                edition.put("project", projectsArray);
                editionsArray.add(edition);
            }
            jsonObject.put("editions", editionsArray);
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);
    }
}

