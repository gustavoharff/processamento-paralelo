Long nEps = 2

int tam = 5

int[] vetor = [100000, 8, 100001, 9, 100002]

Arrays.sort(vetor)

List<Thread> threads = new ArrayList<Thread>()

for (int i = 0; i < nEps; i++) {
    final int currentThread = i

    Runnable runnable = new Runnable() {
        void run() {
            for (int y = currentThread; y < vetor.size(); y += nEps) {
                BigDecimal fat = 1

                for (int j = 2; j <= vetor[y]; j++) {
                    fat = (fat * j).toBigDecimal()
                }

                println("Fatorial de ${vetor[y]}, executado pela thread ${Thread.currentThread().name} em ${System.currentTimeMillis()}")
            }
        }
    }

    Thread thread = new Thread(runnable)

    threads.add(thread)
}

for (Thread thread : threads) {
    thread.start()
}