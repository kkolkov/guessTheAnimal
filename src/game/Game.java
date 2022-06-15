package game;

import database.InMemoryDb;
import manager.InMemoryDbManager;

import java.util.Scanner;

public class Game {
    private static final InMemoryDb landAnimals = InMemoryDb.getInstance();
    private static final InMemoryDb seaAnimals = InMemoryDb.getInstance();
    public static void start() {
        var landManager = new InMemoryDbManager();
        var seaManager = new InMemoryDbManager();

        landManager.setDatabase(landAnimals);
        landManager.setIterator();

        seaManager.setDatabase(seaAnimals);
        seaManager.setIterator();

        var defaultLandAnimal = "кот";
        var defaultSeaAnimal = "кит";

        String newAnimalFromUser;
        String newAnimalBehavior;

        System.out.println("Загадай животное, а я попробую угадать...\n");
        System.out.println("Это животное живет на суше? (да/нет)");

        Scanner inputReader = new Scanner(System.in);

        var userChoice = inputReader.nextLine();
        while (true) {
            switch (userChoice) {
                case "да" -> {
                    while (landManager.hasValue()) {
                        landManager.runIterator();
                        userChoice = inputReader.nextLine();
                        if (userChoice.equals("да")) {
                            System.out.println("Похоже, это " + landManager.getAnswer(landManager.getCurrentValue()));
                            System.out.println("Предлагаю сыграть еще раз");
                            userChoice = inputReader.nextLine();
                            while (true) {
                                switch (userChoice) {
                                    case "да" -> Game.start();
                                    case "нет" -> {
                                        System.out.println("Спасибо за игру");
                                        System.exit(0);
                                    }
                                    default -> {
                                        System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                        userChoice = inputReader.nextLine();
                                    }
                                }
                            }
                        } else if (!userChoice.equals("нет")) {
                            System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                            inputReader.nextLine();
                        }
                    }
                    System.out.println("Это кот?");
                    userChoice = inputReader.nextLine();
                    while (true) {
                        switch (userChoice) {
                            case "да" -> {
                                System.out.println("Предлагаю сыграть еще раз");
                                userChoice = inputReader.nextLine();
                                while (true) {
                                    switch (userChoice) {
                                        case "да" -> Game.start();
                                        case "нет" -> {
                                            System.out.println("Спасибо за игру");
                                            System.exit(0);
                                        }
                                        default -> {
                                            System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                            userChoice = inputReader.nextLine();
                                        }
                                    }
                                }
                            }
                            case "нет" -> {
                                System.out.println("Какое животное ты загадал?");
                                newAnimalFromUser = inputReader.nextLine();
                                System.out.printf("Чем %s отличается от %s?\n", newAnimalFromUser, defaultLandAnimal);
                                newAnimalBehavior = inputReader.nextLine();
                                System.out.println("Предлагаю сыграть еще раз");
                                landManager.addNewValue(newAnimalFromUser, newAnimalBehavior);
                                userChoice = inputReader.nextLine();
                                while (true) {
                                    switch (userChoice) {
                                        case "да" -> Game.start();
                                        case "нет" -> {
                                            System.out.println("Спасибо за игру");
                                            System.exit(0);
                                        }
                                        default -> {
                                            System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                            userChoice = inputReader.nextLine();
                                        }
                                    }
                                }
                            }
                            default -> {
                                System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                userChoice = inputReader.nextLine();
                            }
                        }
                    }
                }
                case "нет" -> {
                    while (seaManager.hasValue()) {
                        seaManager.runIterator();
                        userChoice = inputReader.nextLine();
                        if (userChoice.equals("да")) {
                            System.out.println("Похоже, это " + seaManager.getAnswer(seaManager.getCurrentValue()));
                            System.out.println("Предлагаю сыграть еще раз");
                            userChoice = inputReader.nextLine();
                            while (true) {
                                switch (userChoice) {
                                    case "да" -> Game.start();
                                    case "нет" -> {
                                        System.out.println("Спасибо за игру");
                                        System.exit(0);
                                    }
                                    default -> {
                                        System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                        userChoice = inputReader.nextLine();
                                    }
                                }
                            }
                        } else if (!userChoice.equals("нет")) {
                            System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                            inputReader.nextLine();
                        }
                    }
                    System.out.println("Это кит?");
                    userChoice = inputReader.nextLine();
                    while (true) {
                        switch (userChoice) {
                            case "да" -> {
                                System.out.println("Предлагаю сыграть еще раз");
                                userChoice = inputReader.nextLine();
                                while (true) {
                                    switch (userChoice) {
                                        case "да" -> Game.start();
                                        case "нет" -> {
                                            System.out.println("Спасибо за игру");
                                            System.exit(0);
                                        }
                                        default -> {
                                            System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                            userChoice = inputReader.nextLine();
                                        }
                                    }
                                }
                            }
                            case "нет" -> {
                                System.out.println("Какое животное ты загадал?");
                                newAnimalFromUser = inputReader.nextLine();
                                System.out.printf("Чем %s отличается от %s?\n", newAnimalFromUser, defaultSeaAnimal);
                                newAnimalBehavior = inputReader.nextLine();
                                System.out.println("Предлагаю сыграть еще раз");
                                seaManager.addNewValue(newAnimalFromUser, newAnimalBehavior);
                                userChoice = inputReader.nextLine();
                                while (true) {
                                    switch (userChoice) {
                                        case "да" -> Game.start();
                                        case "нет" -> {
                                            System.out.println("Спасибо за игру");
                                            System.exit(0);
                                        }
                                        default -> {
                                            System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                            userChoice = inputReader.nextLine();
                                        }
                                    }
                                }
                            }
                            default -> {
                                System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                                userChoice = inputReader.nextLine();
                            }
                        }
                    }
                }
                default -> {
                    System.out.println("Необходимо выбрать \"да\" или \"нет\". Попробуй еще раз.");
                    userChoice = inputReader.nextLine();
                }
            }
        }
    }
}
