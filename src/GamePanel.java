import java.awt.*; // Importa clases para gráficos
import java.awt.event.*; // Importa clases para eventos
import javax.swing.*; // Importa clases para interfaces gráficas
import java.util.Random; // Importa clase para generar números aleatorios

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600; // Ancho de la pantalla
    static final int SCREEN_HEIGHT = 600; // Alto de la pantalla
    static final int UNIT_SIZE = 25; // Tamaño de cada unidad (cuadro)
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE; // Total de unidades posibles
    static final int DELAY = 75; // Retardo entre movimientos (ms)

    final int x[] = new int[GAME_UNITS]; // Posiciones X de la serpiente
    final int y[] = new int[GAME_UNITS]; // Posiciones Y de la serpiente
    int bodyParts = 6; // Partes iniciales del cuerpo
    int applesEaten; // Contador de manzanas comidas
    int appleX; // Posición X de la manzana
    int appleY; // Posición Y de la manzana
    char direction = 'R'; // Dirección inicial (Derecha)
    boolean running = false; // Estado del juego
    Timer timer; // Temporizador para el juego
    Random random; // Generador de números aleatorios

    GamePanel() {
        random = new Random(); // Inicializa el generador aleatorio
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); // Tamaño del panel
        this.setBackground(Color.black); // Fondo negro
        this.setFocusable(true); // Permite recibir eventos de teclado
        this.addKeyListener(new MyKeyAdapter()); // Añade el listener de teclado
        startGame(); // Inicia el juego
    }

    public void startGame() {
        bodyParts = 6; // Reinicia el tamaño de la serpiente
        applesEaten = 0; // Reinicia el contador de manzanas
        direction = 'R'; // Reinicia la dirección
        for(int i = 0; i < bodyParts; i++){
            x[i] = 0; // Inicializa posiciones X
            y[i] = 0; // Inicializa posiciones Y
        }
        newApple(); // Genera una nueva manzana
        running = true; // Marca el juego como activo
        timer = new Timer(DELAY, this); // Crea el temporizador
        timer.start(); // Inicia el temporizador
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método de la superclase
        draw(g); // Dibuja el juego
    }

    public void draw(Graphics g) {
        if (running) {
            // Dibuja la cuadrícula (opcional)
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT); // Líneas verticales
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE); // Líneas horizontales
            }

            // Dibuja la manzana
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Dibuja la culebrita
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) { // La cabeza
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else { // El cuerpo
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            // Muestra la puntuación
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Puntuación: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Puntuación: " + applesEaten)) / 2, g.getFont().getSize());
        } else {
            gameOver(g); // Si no está corriendo, muestra el fin del juego
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE; // Nueva posición X aleatoria
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE; // Nueva posición Y aleatoria
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1]; // Mueve cada parte a la posición de la anterior (X)
            y[i] = y[i - 1]; // Mueve cada parte a la posición de la anterior (Y)
        }

        // Cambia la dirección de la cabeza
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE; // Arriba
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE; // Abajo
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE; // Izquierda
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE; // Derecha
                break;
        }

        // Lógica de "teletransporte" en los bordes
        if (x[0] < 0) {
            x[0] = SCREEN_WIDTH - UNIT_SIZE;
        } else if (x[0] >= SCREEN_WIDTH) {
            x[0] = 0;
        }

        if (y[0] < 0) {
            y[0] = SCREEN_HEIGHT - UNIT_SIZE;
        } else if (y[0] >= SCREEN_HEIGHT) {
            y[0] = 0;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) { // Si la cabeza toca la manzana
            bodyParts++; // Aumenta el tamaño
            applesEaten++; // Suma una manzana
            newApple(); // Genera otra manzana
        }
    }

    public void checkCollisions() {
        // Colisión con el cuerpo
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false; // Termina el juego
                timer.stop(); // Detiene el temporizador
            }
        }
    }

    public void gameOver(Graphics g) {
        // Muestra la puntuación final
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Puntuación: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Puntuación: " + applesEaten)) / 2, g.getFont().getSize());

        // Mensaje de fin del juego
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("¡Fin del juego!", (SCREEN_WIDTH - metrics2.stringWidth("¡Fin del juego!")) / 2, SCREEN_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move(); // Mueve la serpiente
            checkApple(); // Verifica si comió manzana
            checkCollisions(); // Verifica colisiones
        }
        repaint(); // Redibuja el panel
    }

    public void pauseGame() {
        running = false; // Pausa el juego
        timer.stop(); // Detiene el temporizador
    }

    public void resumeGame() {
        running = true; // Reanuda el juego
        timer.start(); // Inicia el temporizador
    }

    public void restartGame(){
        startGame(); // Reinicia el juego
    }

    public boolean isRunning(){
        return running; // Devuelve si el juego está activo
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            // Cambia la dirección según la tecla presionada
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}