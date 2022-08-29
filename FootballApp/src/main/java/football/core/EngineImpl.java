

package football.core;

import football.common.Command;
import football.entities.field.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import static football.common.ConstantMessages.*;

public class EngineImpl implements Engine{
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();//TODO implement first
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }
    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddField:

                result = addField(data);
                break;
            case DeliverySupplement:
                result = deliverySupplement(data);
                break;
            case SupplementForField:
                result = supplementForField(data);
                break;
            case AddPlayer:
                result = addPlayer(data);
                break;
            case DragPlayer:
                result = dragPlayer(data);
                break;
            case CalculateStrength:
                result = calculateStrength(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }
    private String addField(String[] data) {
        String command=data[0];

        controller.addField(data[0],data[1]);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE,command) ;
    }

    private String deliverySupplement(String[] data) {
        String command=data[0];
        controller.deliverySupplement(command);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE,command);
    }

    private String supplementForField(String[] data) {
         String command=data[0];
         controller.supplementForField(command,data[1]);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,data[1],command);
    }

    private String addPlayer(String[] data) {
        String command=data[0];
        controller.addPlayer(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]));
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,data[1],command);
    }

    private String dragPlayer(String[] data)  {
        String command=data[0];
        String number = controller.dragPlayer(command);

        return String.format(PLAYER_DRAG,Integer.parseInt(number));
    }

    private String calculateStrength(String[] data) {

        String number = controller.calculateStrength(data[0]);
        return number;
    }

    private String getStatistics() {

      return controller.getStatistics();

    }
}
