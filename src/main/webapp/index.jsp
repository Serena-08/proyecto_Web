<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
   <title>Inicio</title>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
          <div class="container">
              <a class="navbar-brand fw-bold" href="#"><i class="bi bi-chat-quote-fill"></i> SeedNow </a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                  <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                  <ul class="navbar-nav">
                      <li class="nav-item"><a class="nav-link" href="#features"> Características </a></li>
                      <li class="nav-item ms-lg-3">
                          <a href="app.jsp" class="btn btn-primary rounded-pill px-4"> Ir a la App </a>
                      </li>
                  </ul>
              </div>
          </div>
      </nav>

      <header class="hero-section text-center text-white d-flex align-items-center">
          <div class="container">
              <div class="row justify-content-center">
                  <div class="col-lg-8">
                      <h1 class="display-3 fw-bold mb-4"> Gestiona todas tus redes desde un solo lugar </h1>
                      <p class="lead mb-5 text-white-50">
                          Programa mensajes para WhatsApp, Instagram y LinkedIn en segundos.
                          Optimiza tu tiempo y deja que nuestro bot haga el trabajo duro.
                      </p>
                      <a href="app.jsp" class="btn btn-light btn-lg rounded-pill px-5 fw-bold text-primary shadow">
                          <i class="bi bi-rocket-takeoff me-2"></i> Comenzar Ahora
                      </a>
                  </div>
              </div>
          </div>
      </header>

      <section id="features" class="py-5">
          <div class="container my-5">
              <div class="row text-center">
                  <div class="col-md-4 mb-4">
                      <div class="feature-card p-4 h-100 bg-white shadow-sm rounded">
                          <div class="icon-box mb-3 text-success">
                              <i class="bi bi-whatsapp display-4"></i>
                          </div>
                          <h4 class="fw-bold">WhatsApp Marketing</h4>
                          <p class="text-muted">Envía recordatorios y promociones directamente a los chats de tus clientes.</p>
                      </div>
                  </div>
                  <div class="col-md-4 mb-4">
                      <div class="feature-card p-4 h-100 bg-white shadow-sm rounded">
                          <div class="icon-box mb-3 text-danger">
                              <i class="bi bi-instagram display-4"></i>
                          </div>
                          <h4 class="fw-bold">Feed de Instagram</h4>
                          <p class="text-muted">Mantén tu feed activo programando fotos y descripciones con antelación.</p>
                      </div>
                  </div>
                  <div class="col-md-4 mb-4">
                      <div class="feature-card p-4 h-100 bg-white shadow-sm rounded">
                          <div class="icon-box mb-3 text-primary">
                              <i class="bi bi-linkedin display-4"></i>
                          </div>
                          <h4 class="fw-bold">LinkedIn </h4>
                          <p class="text-muted">Publica ofertas de trabajo y noticias corporativas en el horario laboral perfecto.</p>
                      </div>
                  </div>
              </div>
          </div>
      </section>

      <footer class="bg-dark text-white text-center py-4">
          <div class="container">
              <p class="mb-0">&copy; 2025 SeedNow. Todos los derechos reservados.</p>
          </div>
      </footer>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
